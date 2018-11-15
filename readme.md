lombok注解  
@Getter和@Setter  
@ToString(exclude = "id")  
@EqualsAndHashCode：用在类上，自动生成equals方法和hashCode方法  
@Data：注解在类上，相当于同时使用了@ToString、@EqualsAndHashCode、@Getter、@Setter
和@RequiredArgsConstrutor这些注解，对于POJO类十分有用  
@Builder：增加builder构造类的方法
