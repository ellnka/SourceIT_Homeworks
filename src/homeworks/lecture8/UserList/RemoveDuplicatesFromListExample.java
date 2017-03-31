package homeworks.lecture8.UserList;


import java.util.*;

import static java.util.Arrays.asList;

public class RemoveDuplicatesFromListExample {
    public static void main(String[] args) {
        List<User> users = asList(new User("John"), new User("Sara"),
                new User("Mike"), new User("David"), new User("Sara"),
                new User("Mike"), new User("David"));

        /* Solution using iterator*/
        List<User> distinctUsers =  new ArrayList<>(users);
        ListIterator<User>iterator = distinctUsers.listIterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if(Collections.frequency(distinctUsers, user) > 1) {
                iterator.remove();
            }
        }
        System.out.println(distinctUsers.toString());

        /* Solution using HashSet*/
        System.out.println(Arrays.toString
                (new ArrayList<>(new LinkedHashSet<>(users)).toArray()));
    }
}
