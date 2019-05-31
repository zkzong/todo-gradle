package com.zkzong.gradle.todo;

import org.junit.Assert;
import org.junit.Test;

public class TodoRepositoryTest {

    private TodoRepository repository = new TodoRepository();

    @Test
    public void save() {
        TodoItem item = new TodoItem("zong");
        repository.save(item);
        //Assert.assertNull(repository.query(item.getName()));
        Assert.assertNotNull(repository.query(item.getName()));
    }
}