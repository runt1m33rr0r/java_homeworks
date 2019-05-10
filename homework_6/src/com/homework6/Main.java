package com.homework6;

public class Main {

    public static void main(String[] args) {
	    Post post = new Post("1", "koce boce boce");
	    Post post2 = new Post("2", "koce koce boce");
        Post post3 = new Post("3", "koce boce boce boce");

        System.out.println(post.isTitleSubstring("oce"));
        System.out.println(post.getContentSubstringCount("boce"));

        Blog blog = new Blog();
        blog.addPost(post);
        blog.addPost(post2);
        blog.addPost(post3);

        blog.printPostsWithSubstring("boce");
    }
}
