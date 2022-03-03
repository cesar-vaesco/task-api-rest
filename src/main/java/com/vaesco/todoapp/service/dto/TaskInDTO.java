package com.vaesco.todoapp.service.dto;



import lombok.Data;

import java.time.LocalDateTime;

/*
* Lombok: @Data es la anotación de acceso directo que agrupa las características de @ToString,
* @EqualsAndHashCode, @Getter/@Setter y @RequiredArgsConstructor juntas
* */
@Data
public class TaskInDTO {

    private String title;
    private String description;
    private LocalDateTime eta;

}
