package com.williamspires.acnhapi.Controllers;

import com.williamspires.acnhapi.Exceptions.ToolsNotFoundException;
import com.williamspires.acnhapi.Model.Tools;
import com.williamspires.acnhapi.Repositories.ToolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToolsController {

    private final ToolRepository toolRepository;
    ToolsController(ToolRepository toolRepository){
        this.toolRepository = toolRepository;
    }

    @GetMapping("/tool/{name}")
    public List<Tools> getToolByName(@PathVariable String name) {
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
