package com.balu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.balu.entity.Student;
import com.balu.model.StudentDTO;
import com.balu.service.StudentService;
import com.balu.util.Converter;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Converter converter;
	
	//create student REST API
	@PostMapping("/createStudent")
	public ResponseEntity<String> createStudent(@RequestBody StudentDTO studentDTO)
	{
		final Student student= converter.convertToEntity(studentDTO);
		studentService.createStudent(student);
		return new ResponseEntity<String>("New Student details added", HttpStatus.CREATED);
	}
	
	//update student details REST API
	@PutMapping("/updateStudent/{identity}")
	public StudentDTO updateStudent(@PathVariable("identity") int id, @RequestBody StudentDTO studentDTO)
	{
		Student student1 = converter.convertToEntity(studentDTO);
		return studentService.updateStudent(id, student1);
	}
	
	//get student details by using id REST API
	@GetMapping("/getStudentById/{id}")
	public StudentDTO getStudentById(@PathVariable("id") int id)
	{
		return studentService.getStudentById(id);
	}
	
	//get all student details REST API
	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents()
	{
		return studentService.getAllStudents();
	}
		
	//delete student details by using id REST API
	@DeleteMapping("/deleteStudentById/{id}")
	public String deleteStudentById(@PathVariable("id") int id)
	{
		return studentService.deleteStudentById(id);
	}
		
	//delete all student details REST API
	@DeleteMapping("/deleteAllStudents")
	public ResponseEntity<String> deleteAllStudents()
	{
		studentService.deleteAllStudents();
		return new ResponseEntity<String>("All students details have been deleted",HttpStatus.OK);
	}
		
	//get student by using name REST API
	@GetMapping("/getStudentByName/{name}")
	public List<StudentDTO> getStudentByName(@PathVariable("name") String studentName)
	{
		return studentService.getStudentByName(studentName);
	}
		
	//get student by using email REST API
	@GetMapping("/getStudentByEmail/{email}")
	public List<StudentDTO> getStudentByEmail(@PathVariable("email") String email)
	{
		return studentService.getStudentByEmail(email);
	}
		
	//assign address to student REST API
	@PostMapping("/assignAddressToStudent/{studentId}/{addressId}")
	public StudentDTO assignAddressToStudent(@PathVariable("studentId") int id, @PathVariable("addressId") int addressId)
	{
		return studentService.assignAddressToStudent(id, addressId);
	}


}
