package com.learn.stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class CollectionExample {

	public static void main(String[] args) throws IOException {

		List<Person1> persons = new ArrayList<Person1>();

		Files.lines(Paths.get(System.getProperty("user.dir") + "/src/main/resources/People.txt"))
				.map(line -> {
					String[] s = line.split(" ");
					Person1 p = new Person1(s[0].trim(), Integer.parseInt(s[1]));
					persons.add(p);
					return p;
				}).forEach(System.out::println);

		Stream<Person1> stream1 = persons.stream();

		Optional<Person1> opt = stream1.filter(p -> p.getAge() >= 20).min(comparing(Person1::getAge));

		System.out.println("The yongest person in the group whose age is greater than 20 is " + opt.get().getName()
				+ " and person's age is " + opt.get().getAge());

		Optional<Person1> opt1 = persons.stream().max(comparing(Person1::getAge));

		System.out.println("The oldest person in the group is " + opt1.get().getName() + " and person's age is "
				+ opt1.get().getAge());

		Map<Integer, List<Person1>> map = persons.stream().collect(groupingBy(Person1::getAge));

		System.out.println(map);

		Map<Integer, Long> map1 = persons.stream().collect(groupingBy(Person1::getAge, counting()));

		System.out.println(map1);

		Map<Integer, Set<String>> map2 = persons.stream().collect(groupingBy(Person1::getAge, mapping(Person1::getName, toCollection(HashSet::new))));

		System.out.println(map2);

		Map<Integer, String> map3 = persons.stream().collect(groupingBy(Person1::getAge, mapping(Person1::getName, joining(", "))));

		System.out.println(map3);

		Map<String, String> map4 = persons.stream().collect(groupingBy(Person1::getName, mapping(p -> String.valueOf(p.getAge()), joining())));

		System.out.println(map4);

		map4.forEach((k, v) -> {
			String format = "%-20s%s%n";
			System.out.printf(format, "Person = " + k, "Age = " + v);
		});

		Map<String, Integer> map5 = persons.stream().collect(groupingBy(Person1::getName, mapping(Person1::getAge, summingInt(Integer::valueOf))));
		
		System.out.println(map5);
		
		Map<String, Integer> map6 = persons.stream().collect(toMap(Person1::getName, Person1::getAge));
		
		System.out.println(map6);

	}

}
