package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.SongService;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongUploadController {
    @Value("${file-upload}")
    String fileUpload;

    SongService songService = new SongService();

    @GetMapping("/upload")
    public ModelAndView showUploadForm() {
        ModelAndView modelAndView = new ModelAndView("upload");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView upload(@ModelAttribute(name="songForm") SongForm songForm){
        MultipartFile file = songForm.getFile();
        String fileName = file.getOriginalFilename();

        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getGenre(), fileName);
        songService.add(song);

        ModelAndView modelAndView = new ModelAndView("upload");
        modelAndView.addObject("songForm", new SongForm());
        modelAndView.addObject("message", "Succeeded!");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }
}
