package pl.korniak.jacek.patronage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.korniak.jacek.patronage.model.Message;
import pl.korniak.jacek.patronage.model.Player;
import pl.korniak.jacek.patronage.service.PlayerService;

import java.util.List;


@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @RequestMapping(value = "/", method = RequestMethod.POST,
    consumes = { MediaType.APPLICATION_JSON_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public @ResponseBody Message create(@RequestBody Player player) {
    return playerService.create(player);
    }

    @RequestMapping(value = "/{playerId}", method = RequestMethod.PUT,
    consumes = { MediaType.APPLICATION_JSON_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody Message update(@PathVariable String playerId,
                                        @RequestBody Player player) {
    return playerService.update(Long.parseLong(playerId), player);
    }

    @RequestMapping(value = "/{playerId}", method = RequestMethod.GET,
    consumes = { MediaType.APPLICATION_JSON_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody Player get(@PathVariable String playerId) {
        return playerService.get(Long.parseLong(playerId));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET,
    consumes = { MediaType.APPLICATION_JSON_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody List<Player> getAll() {
    return playerService.getAll();
    }

    @RequestMapping(value = "/{playerId}", method = RequestMethod.DELETE,
    consumes = { MediaType.APPLICATION_JSON_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody Message delete(@PathVariable String playerId) {
    return playerService.delete(Long.parseLong(playerId));
    }


}
