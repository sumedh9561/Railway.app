package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	
	private StudentRepository sRepo;

	
	@Autowired
	public StudentController(StudentRepository sRepo) {
		this.sRepo = sRepo;
	}

	
	
	
	
	@PostMapping("/post1")
	public String postReq() {
		return "from Post";
	}

	@PutMapping("/put1")
	public String putReq() {
		return "from Put";
	}

	@GetMapping("/get1")
	public String getReq() {
		return "from Get";
	}

	@DeleteMapping("/delete1")
	public String deleteReq() {
		return "from Delete";
	}

	
	@GetMapping({"/", "/home"})
	public String getHome() {
		return "Home screen Get Request";
	}
	
	


	@PostMapping("/students")
	public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student){
		
		
		
		Student savedStudent= sRepo.save(student);
		
		
		
		return new ResponseEntity<>(savedStudent, HttpStatus.OK);
	}
	
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRoll(@PathVariable Integer roll){
		
		Student student= sRepo.findById(roll).get();
		
		
		return new ResponseEntity<>(student,HttpStatus.OK);
		
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		return sRepo.findAll();
	}
	
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentHandler(@PathVariable Integer roll ){
		
		Student student = sRepo.findById(roll).get();
		
		sRepo.delete(student);
		
		return new ResponseEntity<>(student,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
}
