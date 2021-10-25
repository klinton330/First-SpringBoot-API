package com.hari;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentInfoResource {
	StudentInfoRepository repo=new StudentInfoRepository ();
	@GetMapping("/student")
	public List<StudentInfo>getAll()
	{
		return repo.getStudent();
	}
	
	@GetMapping("/student/{mobile}")
	public StudentInfo getone(@PathVariable String mobile)
	{
		return repo.getParticularStudent(mobile);
		
	}
	
	@PostMapping("/create")
	public StudentInfo createStudent(@RequestBody StudentInfo s)
	{
		System.out.println(s);
		System.out.println(s.getSname());
		System.out.println("Today called"+new Date());
		
		repo.createNewStudent(s);
		return s;
		
	}
	
	@PutMapping("/update/{mobile}")
	public StudentInfo updateStudent(@PathVariable String mobile,@RequestBody StudentInfo s)
	{
	   System.out.println("Update is called"+new Date());
		repo.updateStudent(s,mobile);
		return s;
		
	}
	
	@DeleteMapping("/delete/{mobile}")
		public void deleteStudent(@PathVariable String mobile)
		{
		     System.out.println("hello deleye");
			repo.deleteStudent(mobile);
			//return s;
		}
	
}
