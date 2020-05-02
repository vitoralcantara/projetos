import 'dart:convert';
import 'person.dart';

void main(){

  // decoding JSON
  String rawJson = '{"name":"Mary","age":30}';

  Map<String, dynamic> map = jsonDecode(rawJson);
  String name = map['name'];
  int age = map['age'];
  Person person = Person(name, age);
  print(person.name);
  print(person.age);

  //encoding JSON
  Person anotherPerson = Person('Mary', 30);
  Map<String, dynamic> anotherMap = {
    'name': anotherPerson.name,
    'age': anotherPerson.age
  };
  String newRawJson = jsonEncode(anotherMap);
}
