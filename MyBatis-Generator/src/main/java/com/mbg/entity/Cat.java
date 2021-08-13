package com.mbg.entity;

public class Cat {
    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_cat.id
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_cat.name
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_cat.location
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    private String location;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_cat.type
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    private String type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_cat.id
     *
     * @return the value of t_cat.id
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_cat.id
     *
     * @param id the value for t_cat.id
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_cat.name
     *
     * @return the value of t_cat.name
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_cat.name
     *
     * @param name the value for t_cat.name
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_cat.location
     *
     * @return the value of t_cat.location
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_cat.location
     *
     * @param location the value for t_cat.location
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_cat.type
     *
     * @return the value of t_cat.type
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_cat.type
     *
     * @param type the value for t_cat.type
     *
     * @mbg.generated Thu Aug 12 07:45:08 CST 2021
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}