package cn.link.controller.log;

import cn.link.common.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Link
 * @version 1.0
 * @date 2020/10/29 12:50
 */
@RequestMapping("/log")
@RestController
public class LogController {

    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/do")
    public Response doLog() {

        log.info("info");
        log.debug("debug");
        log.error("error");

        return Response.succeed();

    }

}
