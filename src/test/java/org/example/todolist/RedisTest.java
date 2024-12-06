package org.example.todolist;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.todolist.entities.Task;
import org.example.todolist.repositories.TaskRepository;
import org.example.todolist.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;


@SpringBootTest
@AutoConfigureMockMvc
public class RedisTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private TaskService taskService;

        @Autowired
        private TaskRepository taskRepository;

        @Test
        public void testCreateTaskInDatabase() throws Exception {

            String taskTitle = "Tarea de prueba";


            MvcResult result = mockMvc.perform(post("/tasks/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(taskTitle))
                    .andExpect(status().isOk())
                    .andReturn();


            String jsonResponse = result.getResponse().getContentAsString();
            ObjectMapper objectMapper = new ObjectMapper();
            Task createdTask = objectMapper.readValue(jsonResponse, Task.class);


            assertNotNull(createdTask.getId(), "El ID de la tarea no debería ser nulo");
            assertEquals(taskTitle, createdTask.getTitle(), "El título de la tarea debe coincidir");


            Optional<Task> retrievedTask = taskRepository.findById(createdTask.getId());
            assertTrue(retrievedTask.isPresent(), "La tarea debe existir en la base de datos");
            assertEquals(taskTitle, retrievedTask.get().getTitle(), "El título en la base de datos debe coincidir");
        }
    }
