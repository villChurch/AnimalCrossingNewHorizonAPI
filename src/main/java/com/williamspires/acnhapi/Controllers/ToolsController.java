package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ToolsNotFoundException;
import com.williamspires.acnhapi.Model.ApiEvent;
import com.williamspires.acnhapi.Model.Tools;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.ToolRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Tools", description = "Information on tools")
@RestController
public class ToolsController {

    private final ToolRepository toolRepository;
    private final ApiEventRepository apiEventRepository;
    ToolsController(ToolRepository toolRepository, ApiEventRepository apiEventRepository){
        this.toolRepository = toolRepository;
        this.apiEventRepository = apiEventRepository;
    }

    @Operation(summary = "Get tool by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Tools.class)))),
            @ApiResponse(responseCode = "404", description = "Tool/s not found")
    })
    @GetMapping(value = "/tool/{name}", produces = { "application/json" })
    public List<Tools> getToolByName(@Parameter(description = "Tool name") @PathVariable String name) {
        ApiEvent event = new ApiEvent();
        event.setPath("/tool/" + name);
        apiEventRepository.insertApiEvent(event);
        List<Tools> tools = toolRepository.findToolByName(name);
        if(null == tools || tools.size() < 1){
            throw new ToolsNotFoundException(name);
        }
        return tools;
    }

    /* TO-DO see TollRepository.java
    @GetMapping("/tool/distinct/{name}")
    public Tools getToolByNameDistinct(@PathVariable String name) {
        return toolRepository.findToolsByNameDistinct(name);
    }
 */
}
