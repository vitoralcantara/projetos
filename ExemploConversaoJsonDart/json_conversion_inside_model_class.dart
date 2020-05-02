import 'dart:convert';
import 'person.dart';

void main(){

  //JSON to object
  String rawJson = '{"name":"Mary","age":30}';
  Map<String, dynamic> map = jsonDecode(rawJson);
  Person person = Person.fromJson(map);

  //Object to JSON
  Person anotherPerson = Person('Mary', 30);
  Map<String, dynamic> anotherMap = anotherPerson.toJson();
  String anotherRawJson = jsonEncode(anotherMap);
}