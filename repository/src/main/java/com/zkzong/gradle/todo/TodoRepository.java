package com.zkzong.gradle.todo;

import java.util.HashMap;
import java.util.Map;

public class TodoRepository {

    private static Map<String, TodoItem> items = new HashMap<>();

    /**
     * 保存待办事项
     *
     * @param item
     */
    public void save(TodoItem item) {
        System.out.println("" + item);
        items.put(item.getName(), item);
    }

    /**
     * 查询待办事项
     *
     * @param name
     * @return
     */
    public TodoItem query(String name) {
        return items.get(name);
    }
}
