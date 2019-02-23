
//JSON表示单个对象
var employee = {
    id : 123,
    name : 'Willing',
    age : 22,
    hobby : ['java','C','C++'],
    dept : {
        did : 111,
        dname : '开发部门'
    }
}
console.debug(employee);
//JSON表示多个对象,对象数组
var employees = [employee,employee]
console.debug(employees);

var depts = [{id : 1,name :'ad'},{id : 2, name : 'da'}]
console.debug(depts);
console.debug(depts.toSource());
//标准的JSON字符串应该使用()括起来.
var str = "{name : '你好', age : 19}";
var o = eval("(" + str + ")");
console.debug(o);