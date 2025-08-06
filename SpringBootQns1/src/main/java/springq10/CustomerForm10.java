package springq10;

import jakarta.validation.constraints.*;

public class CustomerForm10 {

    @NotBlank(message = "{customer.name.notblank}")
    @Size(min = 2, max = 30, message = "{customer.name.size}")
    private String name;

    @NotBlank(message = "{customer.email.notblank}")
    @Email(message = "{customer.email.invalid}")
    private String email;

    @NotNull(message = "{customer.age.notnull}")
    @Min(value = 1, message = "{customer.age.range}")
    @Max(value = 150, message = "{customer.age.range}")
    private Integer age;

    @NotBlank(message = "{customer.gender.notblank}")
    private String gender;

    @NotBlank(message = "{customer.birthday.notblank}")
    // simple pattern for mm/dd/yyyy; you can refine with @Pattern
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "{customer.birthday.format}")
    private String birthday;

    @NotBlank(message = "{customer.phone.notblank}")
    @Pattern(regexp = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\d{3}-\\d{4}-\\d{4})$",
             message = "{customer.phone.invalid}")
    private String phone;

    // Getters and setters omitted for brevity (generate them)
    // ...
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
