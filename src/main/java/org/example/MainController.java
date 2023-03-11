package org.example;

import org.example.domain.Task;
import org.example.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "main";
    }

    @PostMapping("/")
    public String addTask(
            @RequestParam String text,
            @RequestParam String status,
            Map<String, Object> model
    ) {
        Task task = new Task(text, status);
        taskRepo.save(task);

        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);

        return "main";
    }

    @PostMapping("/filter")
    public String filterTask(
            @RequestParam String status,
            Map<String, Object> model
    ) {
        Iterable<Task> tasks;
        if (status == null || status.isBlank()) {
            tasks = taskRepo.findAll();
        } else {
            tasks = taskRepo.findByStatus(status);
        }

        model.put("tasks", tasks);
        return "main";
    }
}
