package org.bulletin_board.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {
        "org.bulletin_board.dao",
        "org.bulletin_board.service"})
public class ConfigAppProject {
}
