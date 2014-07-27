/*
 * Copyright 2014 Your Organisation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.professional_webworkx.javafxdemoapp.domain;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 * @version 1.0
 */
public class Person implements Serializable {

    private StringProperty firstNameProperty    = new SimpleStringProperty();
    private StringProperty lastNameProperty     = new SimpleStringProperty();
    private StringProperty eMailProperty        = new SimpleStringProperty();

    public Person() {
    }
    
    public Person(final String firstName, final String lastName, final String email) {
        this.firstNameProperty.set(firstName);
        this.lastNameProperty.set(lastName);
        this.eMailProperty.set(email);
    }

    /**
     * @return the firstNameProperty
     */
    public StringProperty getFirstNameProperty() {
        return firstNameProperty;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstNameProperty.get();
    }
    
    /**
     * @param firstNameProperty the firstNameProperty to set
     */
    public void setFirstNameProperty(StringProperty firstNameProperty) {
        this.firstNameProperty = firstNameProperty;
    }

    /**
     * @return the lastNameProperty
     */
    public StringProperty getLastNameProperty() {
        return lastNameProperty;
    }

    /**
     * @param lastNameProperty the lastNameProperty to set
     */
    public void setLastNameProperty(StringProperty lastNameProperty) {
        this.lastNameProperty = lastNameProperty;
    }

    /**
     * @return the eMailProperty
     */
    public StringProperty geteMailProperty() {
        return eMailProperty;
    }

    /**
     * @param eMailProperty the eMailProperty to set
     */
    public void seteMailProperty(StringProperty eMailProperty) {
        this.eMailProperty = eMailProperty;
    }
}
