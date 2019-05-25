package com.homework6;

public class Main {

    public static void main(String[] args) {
	    Post post = new Post("1 test", "text test test");
	    Post post2 = new Post("2 text", "text text test");
        Post post3 = new Post("3 test", "test test test text");

        System.out.println(post.isTitleSubstring("est"));
        System.out.println(post.getContentSubstringCount("test"));

        Blog blog = new Blog();
        blog.addPost(post);
        blog.addPost(post2);
        blog.addPost(post3);

        blog.printPostsWithSubstring("test");
    }
}
