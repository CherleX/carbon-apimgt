package org.wso2.carbon.apimgt.rest.api.admin.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * Throttling Conditions
 */
@ApiModel(description = "Throttling Conditions")
public class ThrottleConditionDTO   {
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    HEADERCONDITION("HeaderCondition"),
    
    IPCONDITION("IPCondition"),
    
    JWTCLAIMSCONDITION("JWTClaimsCondition"),
    
    QUERYPARAMETERCONDITION("QueryParameterCondition");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("invertCondition")
  private Boolean invertCondition = false;

  public ThrottleConditionDTO type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ThrottleConditionDTO invertCondition(Boolean invertCondition) {
    this.invertCondition = invertCondition;
    return this;
  }

   /**
   * Get invertCondition
   * @return invertCondition
  **/
  @ApiModelProperty(value = "")
  public Boolean getInvertCondition() {
    return invertCondition;
  }

  public void setInvertCondition(Boolean invertCondition) {
    this.invertCondition = invertCondition;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThrottleConditionDTO throttleCondition = (ThrottleConditionDTO) o;
    return Objects.equals(this.type, throttleCondition.type) &&
        Objects.equals(this.invertCondition, throttleCondition.invertCondition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, invertCondition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThrottleConditionDTO {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    invertCondition: ").append(toIndentedString(invertCondition)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

