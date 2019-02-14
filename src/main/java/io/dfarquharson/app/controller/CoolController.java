package io.dfarquharson.app.controller;

import io.dfarquharson.app.controller.base.HttpCrudController;
import io.dfarquharson.app.model.CoolThing;
import io.dfarquharson.app.service.CoolService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cool")
public class CoolController extends HttpCrudController<CoolThing, CoolService> {

    public CoolController(CoolService coolService) {
        super(coolService);
    }

}
