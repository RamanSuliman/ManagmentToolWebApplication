package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@ResponseBody
@RequestMapping("/api")
public class TaskController 
{

    @PostMapping("/tasks")
    public String getTasks() {
        String json = "{\n" +
                "        \"sections\": [\n" +
                "            {\n" +
                "                \"id\": \"section_ToDo\",\n" +
                "                \"title\": \"To Do\",\n" +
                "                \"tasks\": [\n" +
                "                    {\n" +
                "                        \"id\": \"1\",\n" +
                "                        \"title\": \"Task 1\",\n" +
                "                        \"description\": \"Description for Task 1\",\n" +
                "                        \"btn_text\": \"Button text for Task 1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"id\": \"2\",\n" +
                "                        \"title\": \"Task 2\",\n" +
                "                        \"description\": \"Description for Task 2\",\n" +
                "                        \"btn_text\": \"Button text for Task 2\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"section_InProgress\",\n" +
                "                \"title\": \"In Progress\",\n" +
                "                \"tasks\": [\n" +
                "                    {\n" +
                "                        \"id\": \"3\",\n" +
                "                        \"title\": \"Task 3\",\n" +
                "                        \"description\": \"Description for Task 3\",\n" +
                "                        \"btn_text\": \"Button text for Task 3\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"id\": \"4\",\n" +
                "                        \"title\": \"Task 4\",\n" +
                "                        \"description\": \"Description for Task 4\",\n" +
                "                        \"btn_text\": \"Button text for Task 4\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"section_Done\",\n" +
                "                \"title\": \"Done\",\n" +
                "                \"tasks\": [\n" +
                "                    {\n" +
                "                        \"id\": \"5\",\n" +
                "                        \"title\": \"Task 5\",\n" +
                "                        \"description\": \"Description for Task 5\",\n" +
                "                        \"btn_text\": \"Button text for Task 5\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"id\": \"6\",\n" +
                "                        \"title\": \"Task 6\",\n" +
                "                        \"description\": \"Description for Task 6\",\n" +
                "                        \"btn_text\": \"Button text for Task 6\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }";
        
        return json;
    }
}
