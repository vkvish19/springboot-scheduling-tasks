package com.github.vkvish19.springboot_scheduling_tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ScheduledTasks
{
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 30000)
    public void listFiles() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        String dir = "D:\\windowscommands";
        Path winDir = Paths.get(dir);
        try(Stream<Path> stream = Files.list(winDir))
        {
            List<String> filesList = stream
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .toList();
            System.out.println("Files in the windowsCommand folder:-");
            log.info("Files in the windowsCommand folder:-");

            filesList.forEach(log::info);
        }
        catch(IOException e)
        {
            System.err.println("Error listing files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
