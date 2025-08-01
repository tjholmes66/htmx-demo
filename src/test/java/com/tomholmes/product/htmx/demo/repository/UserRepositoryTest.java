package com.tomholmes.product.htmx.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.htmx.demo.model.PositionEntity;
import com.tomholmes.product.htmx.demo.model.UserEntity;

public class UserRepositoryTest extends BaseRepositoryTests
{
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    private long id = 2;
    private boolean active = true;
    private String address1 = "123 main street";
    private String address2 = "Apt. 456";
    private boolean admin = false;
    private String dob = "11/03/1966";
    private LocalDate birthDate = null;
    private String city = "Randolph";
    private long companyId = 0;
    private String firstname = "first_name";
    private String lastname = "last_name";
    private String password = "passwd";
    private String username = "usernm";
    private String prefix = "Mr.";
    private String suffix = "Jr.";
    private String state = "MA";
    private String zip = "12345-1234";
    private long positionId = 2;

    private String email = "test@test.net";
    private String securityQuestion1 = "Meaning of Life?";
    private String securityAnswer1 = "42";
    private String securityQuestion2 = "What city were you born in?";
    private String securityAnswer2 = "Fall River";

    @Test
    public void testUserCreate() throws Exception
    {
        System.out.println("testUserCreate: START");
        // =================================================================================
        PositionEntity position = new PositionEntity();
        position.setPositionId(positionId);
        // =================================================================================
        UserEntity user = new UserEntity();
        user.setActive(active);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPassword(password);
        user.setUsername(username);
        user.setPosition(position);
        user.setFirstName(firstname);
        user.setLastName(lastname);

        user.setEmail(email);
        user.setSecurityQuestion1(securityQuestion1);
        user.setSecurityAnswer1(securityAnswer1);
        user.setSecurityQuestion2(securityQuestion2);
        user.setSecurityAnswer2(securityAnswer2);

        System.out.println("testUserCreate: " + user.toString());
        // ***************************************************************
        System.out.println("testUserCreate: START: CREATE");
        user = userRepository.save(user);
        assertNotNull(user);
        System.out.println("testUserCreate: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testUserRetrieveAll()
    {
        System.out.println("testUserRetrieveAll: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testUserRetrieveAll: START: CREATE");
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        assertNotNull(users);
        for (UserEntity user : users)
        {
            assertNotNull(user.getUserId());
            // assertNotNull(user.isActive());
            // ************************************************************
// assertEquals(user.getAddress1(),address1);
// assertEquals(user.getAddress2(),address2);
// assertEquals(user.getCity(),city);
// assertEquals(user.getCompanyId(),companyId);
// assertEquals(user.getFirstName(),firstName);
// assertEquals(user.getId(),id);
// assertEquals(user.getLastName(),lastName);
// //assertEquals(user.getMiddleName(),middleName);
// assertEquals(user.getPassword(),password);
// assertEquals(user.getPrefix(),prefix);
// assertEquals(user.getState(),state);
// assertEquals(user.getSuffix(),suffix);
// assertEquals(user.getUsername(),username);
// assertEquals(user.getZip(),zip);
// ************************************************************
            System.out.println("testUserRetrieveAll: user=" + user.toString());
        }
        System.out.println("testUserRetrieveAll: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testUserRetrieveById()
    {
        System.out.println("testUserRetrieveById: START");
        // =================================================================================
        long id = 1;
        // =================================================================================
        // ***************************************************************
        System.out.println("testUserRetrieveById: START: CREATE");
        UserEntity user = userRepository.findById(id).orElse(null);
        assertNotNull(user.getUserId());
        // assertNotNull(user.isActive());
        // ************************************************************
        assertEquals(user.getFirstName(), "Demo");
        assertEquals(user.getUserId(), id);
        assertEquals(user.getLastName(), "Demo");
        assertEquals(user.getPassword(), "demo");
        assertEquals(user.getUsername(), "demo");

        assertEquals("tom@tomholmes.net", user.getEmail());
        // ************************************************************
        System.out.println("testUserRetrieve: user=" + user.toString());
        System.out.println("testUserRetrieveById: FINISH: CREATE");
        // =================================================================================
    }

    /*
    @Test
    public void testUserRetrieveByEmail()
    {
        System.out.println("testUserRetrieveByEmail: START");
        // =================================================================================
        String email = "tom@tomholmes.net";
        // =================================================================================
        // ***************************************************************
        System.out.println("testUserRetrieveByEmail: START: CREATE");
        UserEntity exampleEntity = new UserEntity();
        exampleEntity.setEmail(email);
    
        System.out.println("testUserRetrieveByEmail: START: CREATE");
        List<UserEntity> users = userRepository.getUserEntityByEmail(email);
        assertNotNull(users);
        assertEquals(1, users.size());
        UserEntity user = users.get(0);
        assertNotNull(user.getUserId());
    
        // ************************************************************
        assertEquals(user.getEmail(), email);
        // ************************************************************
        System.out.println("testUserRetrieveByEmail: user=" + user.toString());
        System.out.println("testUserRetrieveByEmail: FINISH: CREATE");
        // =================================================================================
    }
    */

    /*
    @Test
    public void testUserRetrieveByUsername()
    {
        System.out.println("testUserRetrieveByUsername: START");
        // =================================================================================
        String username = "demo";
        // =================================================================================
        // ***************************************************************
        System.out.println("testUserRetrieveByUsername: START: CREATE");
        UserEntity exampleEntity = new UserEntity();
        exampleEntity.setUsername(username);
    
        System.out.println("testUserRetrieveByUsername: START: CREATE");
        List<UserEntity> users = userRepository.getUserEntityByUsername(username);
        assertNotNull(users);
        assertEquals(1, users.size());
        UserEntity user = users.get(0);
        assertNotNull(user.getUserId());
    
        // ************************************************************
        assertEquals(user.getUsername(), username);
        // ************************************************************
        System.out.println("testUserRetrieveByUsername: user=" + user.toString());
        System.out.println("testUserRetrieveByUsername: FINISH: CREATE");
        // =================================================================================
    }
    */

    /*
    @Test
    public void testUserRetrieveByExample()
    {
        System.out.println("testUserRetrieveByExample: START");
        // =================================================================================
        UserEntity exampleEntity = new UserEntity();
        exampleEntity.setUsername("demo");
        // =================================================================================
        // ***************************************************************
        System.out.println("testUserRetrieveByExample: START: CREATE");
        List<UserEntity> users = userRepository.getUsersEntity(exampleEntity);
        UserEntity user = users.get(0);
        assertNotNull(user.getUserId());
        // assertNotNull(user.isActive());
        // ************************************************************
        assertEquals(user.getFirstname(), "Demo");
        assertEquals(user.getUserId(), id);
        assertEquals(user.getLastname(), "Demo");
        assertEquals(user.getPassword(), "demo");
        assertEquals(user.getUsername(), "demo");
        // ************************************************************
        System.out.println("testUserRetrieveByExample: user=" + user.toString());
        System.out.println("testUserRetrieveByExample: FINISH: CREATE");
        // =================================================================================
    }
    */

    @Test
    public void testUserRetrieveByUsernamePassword()
    {
        System.out.println("testUserRetrieveByUsernamePassword: START");
        // =================================================================================
        int id = 1;
        String username = "demo";
        String password = "demo";
        // =================================================================================
        // ***************************************************************
        System.out.println("testUserRetrieveByUsernamePassword: START: CREATE");
        List<UserEntity> users = userRepository.findUserByUsernameAndPassword(username, password);
        assertNotNull(users);
        assertEquals(1, users.size());
        UserEntity user = users.get(0);
        assertNotNull(user.getUserId());
        // ************************************************************
        assertEquals(user.getFirstName(), "Demo");
        assertEquals(user.getUserId(), id);
        assertEquals(user.getLastName(), "Demo");
        assertEquals(user.getPassword(), "demo");
        assertEquals(user.getUsername(), "demo");
        // ************************************************************
        System.out.println("testUserRetrieveByExample: user=" + user.toString());
        System.out.println("testUserRetrieveByExample: FINISH: CREATE");
        // =================================================================================
    }

    // @Test
    public void testUserDelete()
    {
        System.out.println("testUserDelete: START");
        long id = 3;
        // =================================================================================
        UserEntity user = userRepository.findById(null).orElse(null);
        assertNotNull(user);
        System.out.println("testUserDelete: " + user.toString());
        userRepository.delete(user);
        System.out.println("testUserDelete: user deleted");
        user = userRepository.findById(null).orElse(null);
        assertEquals(user, null);
        // ***************************************************************
        System.out.println("testUserDelete: FINISH");
        // =================================================================================
    }

    /*
    public void X_testContactEntityByName() {
    	System.out.println("testContactEntityByName: START");
    	// =================================================================================
    	String interestName1 = "TEST";
    	String interestUuid1 = "AAA";
    	String interestPath1 = "ABC/AAA";
    	ContactEntity interest1 = new ContactEntity();
    	interest1.setContactEntityName(interestName1);
    	interest1.setContactEntityUuid(interestUuid1);
    	interest1.setContactEntityPath(interestPath1);
    	System.out.println("testContactEntityByName: " + interestName1 + " " + interestUuid1 + " " + interestPath1);
    	interest1 = contactRepository.saveContactEntity(interest1);
    	assertNotNull(interest1);
    	// =================================================================================
    	String interestName2 = "TEST";
    	String interestUuid2 = "BBB";
    	String interestPath2 = "ABC/BBB";
    	ContactEntity interest2 = new ContactEntity();
    	interest2.setContactEntityName(interestName2);
    	interest2.setContactEntityUuid(interestUuid2);
    	interest2.setContactEntityPath(interestPath2);
    	System.out.println("testContactEntityByName: " + interestName2 + " " + interestUuid2 + " " + interestPath2);
    	interest2 = contactRepository.saveContactEntity(interest2);
    	assertNotNull(interest2);
    	// =================================================================================
    	String interestName3 = "TEST";
    	String interestUuid3 = "BBB";
    	String interestPath3 = "ABC/BBB";
    	ContactEntity interest3 = new ContactEntity();
    	interest3.setContactEntityName(interestName3);
    	interest3.setContactEntityUuid(interestUuid3);
    	interest3.setContactEntityPath(interestPath3);
    	System.out.println("testContactEntityByName: " + interestName3 + " " + interestUuid3 + " " + interestPath3);
    	interest3 = contactRepository.saveContactEntity(interest3);
    	assertNotNull(interest2);
    	// =================================================================================
    	String interestName = "TEST";
    	List<ContactEntity> interests = contactRepository.getContactEntitysByName(interestName);
    	System.out.println("testContactEntityByName: interests: size=" + interests.size() );
    	assertEquals(3,interests.size());
    	// =================================================================================
    	System.out.println("testContactEntityCRUS: START: DELETE");
    	contactRepository.deleteContactEntity(interest1);
    	contactRepository.deleteContactEntity(interest2);
    	contactRepository.deleteContactEntity(interest3);
    	System.out.println("testContactEntityCRUS: FINISH: DELETE");
    	// =================================================================================
    }
    */

    @Test
    public void testUserUpdate()
    {
        System.out.println("testUserUpdate: START");
        long userId = 2;
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        assertNotNull(userEntity);
        // =================================================================================
        String updateFirstName = "updated_fn4";
        String updateLastName = "updated_ln4";
        String updateEmail = "tommy@tomholmes.net";
        // =================================================================================
        userEntity.setFirstName(updateFirstName);
        userEntity.setLastName(updateLastName);
        userEntity.setEmail(updateEmail);
        // =================================================================================
        userRepository.save(userEntity);
        // =================================================================================
        userEntity = userRepository.findById(userId).orElse(null);
        assertEquals(updateFirstName, userEntity.getFirstName());
        assertEquals(updateLastName, userEntity.getLastName());
        assertEquals(updateEmail, userEntity.getEmail());
        // =================================================================================
        System.out.println("testUserUpdate: FINISH");
    }

}
