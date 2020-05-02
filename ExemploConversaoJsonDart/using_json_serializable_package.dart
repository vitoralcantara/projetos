

void main(){
  String rawJson = '{"name":"Mary","age":30}';
  Map<String, dynamic> map = jsonDecode(rawJson);
  Person2 person2 = Person2.fromJson(map);
}