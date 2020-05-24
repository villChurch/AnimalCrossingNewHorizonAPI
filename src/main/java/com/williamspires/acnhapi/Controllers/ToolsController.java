package com.williamspires.acnhapi.Controllers;

import java.util.List;
import com.williamspires.acnhapi.Model.Tools;
import com.williamspires.acnhapi.Repositories.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToolsController {

    @Autowired
    ToolRepository toolRepository;

    @GetMapping("/tool/{name}")
    public List<Tools> getToolByName(@PathVariable String name) {
        return toolRepository.findToolByName(name);
    }

    /* TO-DO see TollRepository.java
    @GetMapping("/tool/distinct/{name}")
    public Tools getToolByNameDistinct(@PathVariable String name) {
        return toolRepository.findToolsByNameDistinct(name);
    }
 */
}
