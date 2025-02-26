package com.tomholmes.product.htmx.demo.repository;

import java.text.SimpleDateFormat;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
// We dont want the H2 in-memory database
// We will provide a custom `test container` as DataSource, don't replace it.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BaseRepositoryTests
{
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    /*
    @Test
    public void test()
    {
        assertEquals(true, true);
    }
    */

}
