// package com.example.demo.controller;

// import org.springframework.core.io.Resource;
// import org.springframework.core.io.UrlResource;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;

// import java.nio.file.Path;
// import java.nio.file.Paths;

// @Controller
// public class FileController {

//     // Endpoint to serve image file
//     @GetMapping("/image")
//     public ResponseEntity<Resource> getImage() throws Exception {
//         // Path to the image file
//         Path path = Paths.get("src/main/resources/static/images/iNCCU_logo.png");
//         // Load the resource
//         Resource resource = new UrlResource(path.toUri());
//         // Return ResponseEntity with image content type
//         return ResponseEntity.ok()
//                 .contentType(MediaType.IMAGE_JPEG)
//                 .body(resource);
//     }

//     // Endpoint to serve PDF file
//     @GetMapping("/file")
//     public ResponseEntity<Resource> getFile() throws Exception {
//         // Path to the PDF file
//         Path path = Paths.get("src/main/resources/static/pdfexample.pdf");
//         // Load the resource
//         Resource resource = new UrlResource(path.toUri());
//         // Return ResponseEntity with PDF content type
//         return ResponseEntity.ok()
//                 .contentType(MediaType.APPLICATION_PDF)
//                 .body(resource);
//     }
// }
