package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Model.AllCatalogItems;
import com.williamspires.acnhapi.Model.CatalogItems;
import com.williamspires.acnhapi.Repositories.AllCatalogItemsRepository;
import com.williamspires.acnhapi.Repositories.CatalogItemsRepostiory;
import com.williamspires.acnhapi.Utils.WebPageDownloader;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CatalogItemsController {

    private final CatalogItemsRepostiory catalogItemsRepostiory;
    private final AllCatalogItemsRepository allCatalogItemsRepository;

    CatalogItemsController(CatalogItemsRepostiory catalogItemsRepostiory,
                           AllCatalogItemsRepository allCatalogItemsRepository) {
        this.catalogItemsRepostiory = catalogItemsRepostiory;
        this.allCatalogItemsRepository = allCatalogItemsRepository;
    }

    @GetMapping("/catalogItems/all")
    public List<CatalogItems> getAllCatalogItems() {
        return  catalogItemsRepostiory.getAllItems();
    }

    @GetMapping("/catalogItems/{link}")
    @ResponseBody
    public List<String> getMissingItems(@PathVariable String link) {
        List<String> ownedItems = new WebPageDownloader().getPageInfo("https://ehsan.lol/" + link + "/raw");
        List<String> allItems = catalogItemsRepostiory.getAllItems().stream()
                .map(CatalogItems::getName)
                .collect(Collectors.toList());
        List<String> missingItems = allItems.stream()
                .filter(item -> !ownedItems.contains(item.toLowerCase()))
                .sorted()
                .collect(Collectors.toList());
        return missingItems;
    }

    @GetMapping("/catalogItems/all/{link}")
    @ResponseBody
    public List<String> getAllMissingItems(@PathVariable String link ){
        List<String> ownedItems = new WebPageDownloader().getPageInfo("https://ehsan.lol/" + link + "/raw");
        List<String> allItems = allCatalogItemsRepository.getAllItems().stream()
                .map(AllCatalogItems::getName)
                .collect(Collectors.toList());
        List<String> missingItems = allItems.stream()
                .filter(item -> !ownedItems.contains(item.toLowerCase()))
                .sorted()
                .collect(Collectors.toList());
        return missingItems;
    }
    @GetMapping("/catalogItems/ne/{link}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> downloadNEImport(@PathVariable String link) throws IOException {
        File testFile = new File(link+".txt");
        if(!testFile.exists() && !testFile.isDirectory()) {
            WebPageDownloader webPageDownloader = new WebPageDownloader();
            List<String> ownedItems = webPageDownloader.getPageInfo("https://ehsan.lol/" + link + "/raw");
            List<String> allItems = catalogItemsRepostiory.getAllItems().stream()
                    .map(CatalogItems::getName)
                    .collect(Collectors.toList());
            List<String> missingItems = allItems.stream()
                    .filter(item -> !ownedItems.contains(item.toLowerCase()))
                    .sorted()
                    .collect(Collectors.toList());
            webPageDownloader.writeToFile(missingItems, link);
        }

        File file = new File(link+".txt");
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("/catalogItems/all/ne/{link}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> downloadAllNeImport(@PathVariable String link) throws IOException {
        File testFile = new File("all"+link+".txt");
        if(!testFile.exists() && !testFile.isDirectory()) {
            WebPageDownloader webPageDownloader = new WebPageDownloader();
            List<String> ownedItems = webPageDownloader.getPageInfo("https://ehsan.lol/" + link + "/raw");
            List<String> allItems = allCatalogItemsRepository.getAllItems().stream()
                    .map(AllCatalogItems::getName)
                    .collect(Collectors.toList());
            List<String> missingItems = allItems.stream()
                    .filter(item -> !ownedItems.contains(item.toLowerCase()))
                    .sorted()
                    .collect(Collectors.toList());
            webPageDownloader.writeToFile(missingItems, "all"+link);
        }

        Path path = Paths.get(testFile.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .contentLength(testFile.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
