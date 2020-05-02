import 'package:json_annotation/json_annotation.dart';
part 'person2.g.dart';

@JsonSerializable()
class Person2 {
  Person2(this.name, this.age);
  final String name;
  final int age;
  factory Person2.fromJson(Map<String, dynamic> json) =>
      _$Person2FromJson(json);
  Map<String, dynamic> toJson() => _$Person2ToJson(this);
}