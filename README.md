### ✨ ArrayList<Integer> -> int[] 변환 방법   
- `int[] arr = list.stream().mapToInt(i -> i).toArray();`

### ✨ length / length() / size 차이
1. **length**
- `배열의 길이` 를 알고자 할 때 사용 (int[], double[], String[])
2. **length()**
- `문자열의 길이` 를 알고자 할 때 사용 (String, StringBuilder)
3. **size()**
- `컬렉션 프레임워크 타입` 의 길이를 알고자 할 때 사용 (ArrayList, Set)   
  
### ✨ String 정렬 (사전순 정렬)  
**s1.compareTo(s2)**  <br>
- `s1 == s2`  -> `return 0`  
- `s1 > s2` -> `return 양수`  
- `s1 < s2` -> `return  음수`  
