class Person {
  Person(this.name, this.age);

  final String name;
  final int age;

   // named constructor
  Person.fromJson(Map<String, dynamic> json)
      : name = json['name'],
        age = json['age'];
  // method
  Map<String, dynamic> toJson() {
    return {
      'name': name,
      'age': age,
    };
  }
  
}