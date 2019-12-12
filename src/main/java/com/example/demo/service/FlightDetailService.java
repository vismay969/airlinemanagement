package com.example.demo.service;

import com.example.demo.entity.FlightDetailStruct;
import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.repository.FlightDetailRepository;
import com.example.demo.repository.FlightMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FlightDetailService {

    @Autowired
    private FlightDetailRepository fdRepo;

    @Autowired
    private FlightMasterRepository fmRepo;

    public Optional<FlightDetailStruct> getFlightDetailsById(Integer flightSchNo) {
        if (!fdRepo.existsById(flightSchNo)) {
            throw new ResourceNotFoundException("Flight details with id " + flightSchNo + " not found");
        }
        return fdRepo.findById(flightSchNo);
    }


    public FlightDetailStruct addFlightDetail(Integer flightNo, FlightDetailStruct flightDetailStruct) {
        //Set<Book> books = new HashSet<>();
        //Author author1 = new Author();

        Optional<FlightMasterStruct> byId = fmRepo.findById(flightNo);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Flight with id " + flightNo + " does not exist");
        }
        FlightMasterStruct flightMaster = byId.get();

        //tie Author to Book
        flightDetailStruct.setFlightMaster(flightMaster);

       // FlightDetailStruct book1 = fdRepo.save(flightDetailStruct);
        //tie Book to Author
        //books.add(book1);
//        author1.setBooks(books);

        return fdRepo.save(flightDetailStruct);
    }


/*

    public FlightDetailStruct addFlightDetail(@RequestBody FlightDetailStruct flightDetailStruct) {
        return this.fdRepo.save(flightDetailStruct);
    }*/


    public List<FlightDetailStruct> findAllFlightDetails()
    {
        return this.fdRepo.findAll();
    }

/*    public List<FlightDetailStruct> findFlightMasterWithArrAndDept(String arr, String dept)
    {
        return this.fmRepo.findByArrAbbrAndDeptAbbr(arr,dept);
    }*/

}
