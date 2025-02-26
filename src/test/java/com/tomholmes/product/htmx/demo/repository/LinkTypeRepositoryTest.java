package com.tomholmes.product.htmx.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.htmx.demo.model.LinkTypeEntity;

public class LinkTypeRepositoryTest extends BaseRepositoryTests
{
    @Autowired
    private LinkTypeRepository linkTypeRepository;

    @Test
    public void testLinkTypeSave()
    {
        System.out.println("testLinkTypeSave: START");
        // =================================================================================
        String linkTypeName = "Test";
        boolean linkActive = true;
        String linkTypeDescription = "Test Description";
        // =================================================================================
        LinkTypeEntity linkType = new LinkTypeEntity();
        linkType.setId(0);
        linkType.setActive(linkActive);
        linkType.setDescription(linkTypeDescription);
        System.out.println("testLinkTypeSave: " + linkTypeName + " " + linkTypeDescription);
        // ***************************************************************
        System.out.println("testLinkTypeSave: START: CREATE");
        linkType = linkTypeRepository.save(linkType);
        assertNotNull(linkType);
        System.out.println("testLinkTypeSave: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testLinkTypeUpdate()
    {
        System.out.println("testLinkTypeUpdate: START");
        // =================================================================================
        String linkTypeName = "Test Upd";
        boolean linkActive = true;
        String linkTypeDescription = "Test Description Update";
        // =================================================================================
        LinkTypeEntity linkType = new LinkTypeEntity();
        linkType.setId(0);
        linkType.setActive(linkActive);
        linkType.setDescription(linkTypeDescription);
        System.out.println("testLinkTypeUpdate: " + linkTypeName + " " + linkTypeDescription);
        // ***************************************************************
        System.out.println("testLinkTypeUpdate: START: CREATE");
        linkType = linkTypeRepository.save(linkType);
        assertNotNull(linkType);
        assertEquals(linkActive, linkType.isActive());
        assertEquals(linkTypeDescription, linkType.getDescription());
        System.out.println("testLinkTypeUpdate: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testLinkTypeRetrieve()
    {
        System.out.println("testLinkTypeRetrieve: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testLinkTypeRetrieve: START: CREATE");
        List<LinkTypeEntity> linkTypes = (List<LinkTypeEntity>) linkTypeRepository.findAll();
        assertNotNull(linkTypes);
        for (LinkTypeEntity linkType : linkTypes)
        {
            assertNotNull(linkType.getId());
            assertNotNull(linkType.isActive());
            assertNotNull(linkType.getDescription());
            System.out.println("testLinkTypeRetrieve: linkType=" + linkType.getId() + " " + linkType.isActive() + " " + linkType.getDescription());
        }
        System.out.println("testLinkTypeRetrieve: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testLinkTypeRetrieveById()
    {
        System.out.println("testLinkTypeRetrieveById: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testLinkTypeRetrieveById: START: CREATE");
        LinkTypeEntity linkType = linkTypeRepository.findById(1L).orElse(null);
        assertNotNull(linkType.getId());
        assertNotNull(linkType.isActive());
        assertNotNull(linkType.getDescription());
        System.out.println("testLinkTypeRetrieveById: linkType=" + linkType.getId() + " " + linkType.isActive() + " " + linkType.getDescription());
        System.out.println("testLinkTypeRetrieveById: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testLinkTypeDelete()
    {
        System.out.println("testLinkTypeDelete: START");
        // =================================================================================
        long linkTypeId = 1;
        LinkTypeEntity linkType = linkTypeRepository.findById(linkTypeId).orElse(null);
        linkTypeRepository.delete(linkType);

        LinkTypeEntity linkTypeGet = linkTypeRepository.findById(linkTypeId).orElse(null);
        assertEquals(null, linkTypeGet);

        System.out.println("testLinkTypeDelete: FINISH: CREATE");
        // =================================================================================
    }

    /*
    public void X_testLinkTypeEntityByName() {
        System.out.println("testLinkTypeEntityByName: START");
        // =================================================================================
        String interestName1 = "TEST";
        String interestUuid1 = "AAA";
        String interestPath1 = "ABC/AAA";
        LinkTypeEntity interest1 = new LinkTypeEntity();
        interest1.setLinkTypeEntityName(interestName1);
        interest1.setLinkTypeEntityUuid(interestUuid1);
        interest1.setLinkTypeEntityPath(interestPath1);
        System.out.println("testLinkTypeEntityByName: " + interestName1 + " " + interestUuid1 + " " + interestPath1);
        interest1 = linkTypeRepository.saveLinkTypeEntity(interest1);
        assertNotNull(interest1);
        // =================================================================================
        String interestName2 = "TEST";
        String interestUuid2 = "BBB";
        String interestPath2 = "ABC/BBB";
        LinkTypeEntity interest2 = new LinkTypeEntity();
        interest2.setLinkTypeEntityName(interestName2);
        interest2.setLinkTypeEntityUuid(interestUuid2);
        interest2.setLinkTypeEntityPath(interestPath2);
        System.out.println("testLinkTypeEntityByName: " + interestName2 + " " + interestUuid2 + " " + interestPath2);
        interest2 = linkTypeRepository.saveLinkTypeEntity(interest2);
        assertNotNull(interest2);
        // =================================================================================
        String interestName3 = "TEST";
        String interestUuid3 = "BBB";
        String interestPath3 = "ABC/BBB";
        LinkTypeEntity interest3 = new LinkTypeEntity();
        interest3.setLinkTypeEntityName(interestName3);
        interest3.setLinkTypeEntityUuid(interestUuid3);
        interest3.setLinkTypeEntityPath(interestPath3);
        System.out.println("testLinkTypeEntityByName: " + interestName3 + " " + interestUuid3 + " " + interestPath3);
        interest3 = linkTypeRepository.saveLinkTypeEntity(interest3);
        assertNotNull(interest2);
        // =================================================================================
        String interestName = "TEST";
        List<LinkTypeEntity> interests = linkTypeRepository.getLinkTypeEntitysByName(interestName);
        System.out.println("testLinkTypeEntityByName: interests: size=" + interests.size() );
        assertEquals(3,interests.size());
        // =================================================================================
        System.out.println("testLinkTypeEntityCRUS: START: DELETE");
        linkTypeRepository.deleteLinkTypeEntity(interest1);
        linkTypeRepository.deleteLinkTypeEntity(interest2);
        linkTypeRepository.deleteLinkTypeEntity(interest3);
        System.out.println("testLinkTypeEntityCRUS: FINISH: DELETE");
        // =================================================================================
    }
    */

}
