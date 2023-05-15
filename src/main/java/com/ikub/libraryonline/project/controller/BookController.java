package com.ikub.libraryonline.project.controller;

import com.ikub.libraryonline.project.domain.dto.book.*;
import com.ikub.libraryonline.project.domain.entity.BookStatus;
import com.ikub.libraryonline.project.domain.mapper.BookMapper;
import com.ikub.libraryonline.project.service.CategoryService;
import com.ikub.libraryonline.project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<List<BookDTO>> listAllBooks(){
        return ResponseEntity.ok(bookService.listAllBooks());
    }
    @RolesAllowed({"ADMIN"})
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById (@PathVariable Integer id){
        BookDTO b = BookMapper.toDto(bookService.findById(id));
        return ResponseEntity.ok(b);
    }
    @GetMapping("/price/{price}")
    public ResponseEntity<List<BookDTO>> findByPrice(@PathVariable Double price){
        return ResponseEntity.ok(bookService.findAllByPrice(price));
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookDTO>>findByTitle(@PathVariable String title){
        return ResponseEntity.ok(bookService.findBookByTitle(title));
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<List<BookDTO>> getBooksByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(bookService.getBooksByUserId(userId));
    }
    @RolesAllowed({"ADMIN"})
    @PostMapping("/add/{categoryId}")
    public ResponseEntity<BookDTO> addBook (@RequestBody  BookDTO bookDTO,@PathVariable Integer categoryId ){
        return ResponseEntity.ok(bookService.addBook(bookDTO,categoryId));
    }

    @RolesAllowed({"ADMIN"})
    @PutMapping("/{id}")
    public ResponseEntity<BookUpdateDTO> updateBook (@PathVariable Integer id, @RequestBody BookUpdateDTO bookUpdateDTO){
        return ResponseEntity.ok(bookService.updateBook(id,bookUpdateDTO));
    }



    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RolesAllowed({"ADMIN"})
    @GetMapping("/{id}/status")
    public ResponseEntity<BookStatus> setPropertyStatus (@PathVariable Integer id, @RequestParam(required = false)String status){
        return ResponseEntity.ok(bookService.setBookStatus(id,status));
    }
    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<BookDTO>> findBookByCategory(@PathVariable Integer categoryId){
        return ResponseEntity.ok(bookService.findBookByCategory(categoryId));
    }



    @RolesAllowed("ADMIN")
    @PostMapping("/category/add")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.addCategory(categoryDTO));
    }

    @RolesAllowed("ADMIN")
    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> allCategories(){
        return ResponseEntity.ok(categoryService.listAllCategories());
    }


    
}
