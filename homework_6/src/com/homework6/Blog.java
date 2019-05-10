package com.homework6;

import java.util.ArrayList;

public class Blog {

    private ArrayList<Post> posts;

    public Blog() {
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void printPostsWithSubstring(String input) {
        ArrayList<Integer> occurencesCounts = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();

        int maxOccurences = 0;
        for (Post current : this.posts) {
            int occurrences = current.getContentSubstringCount(input);
            occurencesCounts.add(occurrences);

            if (occurrences > maxOccurences) {
                maxOccurences = occurrences;
            }
        }

        int currentOccurence = maxOccurences;
        while (currentOccurence > 0) {
            for (int i = 0; i < occurencesCounts.size(); i++) {
                if (occurencesCounts.get(i) == currentOccurence) {
                    titles.add(this.posts.get(i).getTitle());
                }
            }

            currentOccurence -= 1;
        }

        System.out.println(titles);
    }
}
