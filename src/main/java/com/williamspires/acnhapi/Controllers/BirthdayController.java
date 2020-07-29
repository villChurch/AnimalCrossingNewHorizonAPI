package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.VillagerNotFoundException;
import com.williamspires.acnhapi.Model.Villager;
import com.williamspires.acnhapi.Repositories.VillagerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Tag(name = "Villager Birthdays", description = "Information on Villager Birthdays")
public class BirthdayController {

    private final VillagerRepository villagerRepository;

    BirthdayController(final VillagerRepository villagerRepository) {
        this.villagerRepository = villagerRepository;
    }

    @Operation(summary = "Gets villagers with a birthday on today's date (UTC)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class))))
    })
    @GetMapping("/birthday/current")
    public List<Villager> getCurrentBirthdayUTC() {
        List<Villager> allVillagers = villagerRepository.getAllVillagers();
        Date today = Date.from(Instant.now());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM");
        String todayVillagerFormat = formatter.format(today);
        List<Villager> matchedVillagers = allVillagers.stream()
                .filter(villager -> villager.getBirthday().equals(todayVillagerFormat))
                .collect(Collectors.toList());
        return matchedVillagers;
    }

    @Operation(summary = "Gets villagers with a birthday on todays date with specified offset from UTC")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class))))
    })
    @GetMapping("/birthday/current/{offset}")
    public List<Villager> getVillagersBirthdayTodayWithOffset(@Parameter(description = "Three letter time code, eg. +0100")
                                                              @PathVariable String offset) {
        List<Villager> allVillagers = villagerRepository.getAllVillagers();
        ZoneId zoneId;
        try {
             zoneId = ZoneId.of(offset);
        } catch (ZoneRulesException zre) {
            log.error("Zone id provided {} does not have a corresponding region ID", offset);
            throw new ZoneRulesException("Zone id provided " + offset + " does not have a corresponding region", zre);
        } catch (DateTimeException dte) {
            log.error("Zone id {} has an invalid format", offset);
            throw new DateTimeException("Zone id " + offset + " is in an invalid offset/format", dte);
        } catch (Exception ex) {
            log.error("An unexpected error has happened");
            ex.printStackTrace();
            return null;
        }
        ZonedDateTime todaysDateWithOffset = ZonedDateTime.ofInstant(Instant.now(), zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM");
        String todaysDateWithOffsetString = formatter.format(todaysDateWithOffset);
        List<Villager> matchedVillagers = allVillagers.stream()
                .filter(villager -> villager.getBirthday().equals(todaysDateWithOffsetString))
                .collect(Collectors.toList());
        return matchedVillagers;
    }

    @Operation(summary = "Gets villagers with a birthday tomorrow (UTC)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class))))
    })
    @GetMapping("/birthday/tomorrow")
    public List<Villager> getTomorrowsBirthdaysUTC() {
        List<Villager> allVillagers = villagerRepository.getAllVillagers();
        ZonedDateTime tomorrowZoned = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")).plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM");
        String tomorrowVillagerBirthday = formatter.format(tomorrowZoned);
        List<Villager> matchedVillagers = allVillagers.stream()
                .filter(villager -> villager.getBirthday().equals(tomorrowVillagerBirthday))
                .collect(Collectors.toList());
        return matchedVillagers;
    }

    @Operation(summary = "Gets a specific villagers birthday")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class))))
    })
    @GetMapping("/birthday/{name}")
    public String getVillagersBirthday(@Parameter(description = "Name of villager to get birthday for")
                                           @PathVariable String name) {
        Villager villager = villagerRepository.findVillagerByName(name);
        if (villager == null) {
            throw new VillagerNotFoundException(name);
        } else {
            return villager.getName() + "'s birthday is on " + villager.getBirthday();
        }
    }

    @Operation(summary = "Gets birthdays on a given date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Villager.class))))
    })
    @GetMapping("/birthday/date/{date}")
    public List<Villager> getVillagersBirthdayOnGivenDate(@Parameter(description = "Date in dd-mm format")
                                                          @PathVariable String date) {
        LocalDate localDate = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR),
                Integer.parseInt(date.split("-")[1]),Integer.parseInt(date.split("-")[0]));
        LocalDateTime localDateTime = localDate.atTime(0,0);
        ZonedDateTime givenDateZoned = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM");
        String dateToSearchFor = formatter.format(givenDateZoned);
        List<Villager> matchedVillagers = villagerRepository.getAllVillagers().stream()
                .filter(villager -> villager.getBirthday().equals(dateToSearchFor))
                .collect(Collectors.toList());
        return matchedVillagers;
    }
}
