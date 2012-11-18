package com.chariot.quizzo.web;

import com.chariot.quizzo.db.Player;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/players")
@Controller
@RooWebScaffold(path = "players", formBackingObject = Player.class)
@RooWebJson(jsonObject = com.chariot.quizzo.db.Player.class)
public class PlayerController {
}
