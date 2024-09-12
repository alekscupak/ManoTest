package com.aleksandr.blogca2023.controller;


import com.aleksandr.blogca2023.entities.Comment;
import com.aleksandr.blogca2023.entities.Parking;
import com.aleksandr.blogca2023.repo.CommentRepository;
import com.aleksandr.blogca2023.repo.ParkingRepository;
import com.aleksandr.blogca2023.service.CommentService;
import com.aleksandr.blogca2023.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/parkings")
public class ParkingController {

    private final ParkingService parkingService;
    private final CommentService commentService;

    @Autowired
    private ParkingRepository parkingRepository;



    @GetMapping("/{id}/edit")
    public String editParkingForm(@PathVariable Long id, Model model) {
        Parking parking = parkingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid parking ID: " + id));
        model.addAttribute("parking", parking);
        return "edit_parking"; // Create an HTML template for editing a parking record
    }

    @PostMapping("/{id}/edit")
    public String editParking(@PathVariable Long id, @ModelAttribute Parking editedParking) {
        parkingRepository.save(editedParking);
        return "redirect:/parkings/list"; // Redirect to the parking list page after editing
    }

    @GetMapping("/{id}/delete")
    public String deleteParking(@PathVariable Long id) {
        parkingRepository.deleteById(id);
        return "redirect:/parkings/list"; // Redirect to the parking list page after deletion
    }



    public ParkingController(ParkingService parkingService, CommentService commentService) {
        this.parkingService = parkingService;
        this.commentService = commentService;
    }



    @GetMapping
    public String getParkings(Model model) {
        List<Parking> parkings = parkingService.getAllParkings();
        model.addAttribute("parkings", parkings);
        return "parkings";
    }

    @GetMapping("/{id}")
    public String getParking(@PathVariable Long id,  Model model) {
        model.addAttribute("id", id);
        model.addAttribute("comment", new Comment());
        Parking parking = parkingService.getParking(id);
        model.addAttribute("parking", parking);
        return "parking";
    }

    @PostMapping("/{id}")
    public String addCommentToParking(@PathVariable Long id, Comment comment, Model model) {
        Parking parking = parkingService.getParking(id);
        comment.setParking(parking);
        commentService.addCommentToParking(comment);
        return "redirect:/parkings/" + id;
    }

    @GetMapping("/add")
    public String getAddParkingForm(Model model) {
        model.addAttribute("newParking", new Parking());
        return "addParking";

   }



    @PostMapping
    public String addNewParking(Parking newParking, Model model) {
        parkingService.addNewParking(newParking);
        return "redirect:/parkings";
    }
    @GetMapping("/filter")
    public String filterParkings(@RequestParam String keyword, Model model) {
        List<Parking> parkings = parkingService.filterParkingsByKeyword(keyword);
        model.addAttribute("parkings", parkings);
        return "parkings";
    }

    @GetMapping("/list")
    public String listBooks(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(30);

        Page<Parking> bookPage = parkingService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("parkingPage", bookPage);

        int totalPages = bookPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "listParkings";
    }

    @GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }








}

