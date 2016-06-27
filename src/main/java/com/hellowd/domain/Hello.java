package com.hellowd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by devsh on 2016. 6. 27..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hello")
public class Hello {
}
