package com.mbg.entity;

public class Teacher {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_teacher.id
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_teacher.last_name
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    private String lastName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_teacher.age
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_teacher.location
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    private String location;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_teacher.id
     *
     * @return the value of t_teacher.id
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_teacher.id
     *
     * @param id the value for t_teacher.id
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_teacher.last_name
     *
     * @return the value of t_teacher.last_name
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_teacher.last_name
     *
     * @param lastName the value for t_teacher.last_name
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_teacher.age
     *
     * @return the value of t_teacher.age
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_teacher.age
     *
     * @param age the value for t_teacher.age
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_teacher.location
     *
     * @return the value of t_teacher.location
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_teacher.location
     *
     * @param location the value for t_teacher.location
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }
}