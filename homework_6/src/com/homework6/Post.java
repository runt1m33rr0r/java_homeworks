package com.homework6;

public class Post {
    private static int idGenerator = 1;

    private int id;
    private String title;
    private String text;

    public Post(String title, String text) {
        this.id = Post.getNextId();
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    public int getId() {
        return this.id;
    }

    public boolean isTitleSubstring(String input) {
        return this.title.contains(input);
    }

    public int getContentSubstringCount(String input) {
        String output = this.text;
        int index = output.indexOf(input);
        int count = 0;

        while (index != -1) {
            count++;
            output = output.substring(index + 1);
            index = output.indexOf(input);
        }

        return count;
    }

    private static int getNextId() {
        Post.idGenerator += 1;
        return Post.idGenerator;
    }
}
