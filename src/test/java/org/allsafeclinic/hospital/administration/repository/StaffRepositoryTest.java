package org.allsafeclinic.hospital.administration.repository;


import org.allsafeclinic.hospital.administration.entity.Address;
import org.allsafeclinic.hospital.administration.entity.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StaffRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StaffRepository staffRepository;

    @Test
    public  void findEmployee()
    {
//        String firstName="firstName";
//        String lastName="lastName";
//        Address address=new Address();
//        address.setCity("DummyCity");
//        address.setHouseName("HouseName");
//        String phoneNumber ="911234567890";
//        String email="test@test.com";
//        char gender='M';
//        String department="HR";
//
//
//
//        Staff staff=new  Staff( firstName,  lastName,  19,  address,
//             phoneNumber,  email,  department,  gender) ;
//
//        entityManager.persist(staff);
//        entityManager.flush();
//
//        Optional<Staff> staffFromBD=staffRepository.findById(1L );
//        System.out.println(staffFromBD.get().getFirstName());
//        assertThat
//                (staffFromBD.get().getFirstName().equals("Avinash"));
//
//

    }
}
