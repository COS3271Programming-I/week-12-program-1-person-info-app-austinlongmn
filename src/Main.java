import java.util.Scanner;

// Gender enumeration
enum Gender {
  MALE,
  FEMALE
}

// Person class
class Person {

  String firstName;
  String lastName;
  Gender gender;
  int age;
  float weight;
  float height;
  String ethnicGroup;
  String religion;

  // Displays person in a nice format
  @Override
  public String toString() {
    return String.format(
      "%s %s\nGender: %s\nAge: %d years\nWeight: %.2f lbs\nHeight: %.2f in\nEthnic Group: %s\nReligion: %s",
      firstName,
      lastName,
      gender,
      age,
      weight,
      height,
      ethnicGroup,
      religion
    );
  }
}

class Main {

  // Helper functions to get user input with fault tolerance
  public static float getFloatingPoint(Scanner scanner) {
    while (true) {
      try {
        float providedValue = scanner.nextFloat();

        if (providedValue > 0) {
          return providedValue;
        } else {
          System.err.println("You must enter a positive number.");
        }
      } catch (NumberFormatException e) {
        System.err.println("You must enter a number.");
      } finally {
        scanner.nextLine();
      }
    }
  }

  public static int getPositiveInteger(Scanner scanner) {
    while (true) {
      try {
        int providedValue = scanner.nextInt();

        if (providedValue > 0) {
          return providedValue;
        } else {
          System.err.println("You must enter a positive integer.");
        }
      } catch (NumberFormatException e) {
        System.err.println("You must enter an integer.");
      } finally {
        scanner.nextLine();
      }
    }
  }

  public static Gender getGender(Scanner scanner) {
    while (true) {
      String providedValue = scanner.nextLine();

      if (providedValue.matches("[Mm](ale)?")) {
        return Gender.MALE;
      } else if (providedValue.matches("[Ff](emale)?")) {
        return Gender.FEMALE;
      } else {
        System.err.print(
          "You must enter either male or female (Genesis 1:27). "
        );
      }
    }
  }

  // Wrapper function for consistency with above
  public static String getString(Scanner scanner) {
    return scanner.nextLine();
  }

  public static void main(String[] args) {
    Person person = new Person();

    // Input user data
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Enter the person's first name: ");
      person.firstName = getString(scanner);

      System.out.format("Enter %s's last name: ", person.firstName);
      person.lastName = getString(scanner);

      System.out.format("Enter %s's gender: ", person.firstName);
      person.gender = getGender(scanner);

      System.out.format("Enter %s's age: ", person.firstName);
      person.age = getPositiveInteger(scanner);

      System.out.format("Enter %s's weight in pounds: ", person.firstName);
      person.weight = getFloatingPoint(scanner);

      System.out.format("Enter %s's height: ", person.firstName);
      person.height = getFloatingPoint(scanner);

      System.out.format("Enter %s's ethic group: ", person.firstName);
      person.ethnicGroup = getString(scanner);

      System.out.format("Enter %s's religion: ", person.firstName);
      person.religion = getString(scanner);
    }

    // Output person
    System.out.println(person.toString());
  }
}
