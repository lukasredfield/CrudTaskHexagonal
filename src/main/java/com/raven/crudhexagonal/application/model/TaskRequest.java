package com.raven.crudhexagonal.application.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskRequest {
    Long id;
    String title;
    String content;
}
