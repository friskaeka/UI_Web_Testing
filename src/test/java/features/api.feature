Feature: Test Automation API

  @api
  Scenario: Test Get List Data Normal
    Given prepare url for "GET_LIST_USER"
    And hit api get list user
    Then validation status code is equal 200
    Then validation response body get list user
    Then validation response json with JSONschema "get_list_users_normal.json"

  @api
  Scenario: Test create New User Normal
    Given prepare url for "CREATE_NEW_USER"
    And hit api post create new user
    Then validation status code is equal 201
    Then validation response body post create new user
    Then validation response json with JSONschema "post_create_user_normal.json"

  @api
  Scenario: Test delete user normal
    Given prepare url for "CREATE_NEW_USER"
    And hit api post create new user
    Then validation status code is equal 201
    Then validation response body post create new user
    And hit api delete user
    Then validation status code is equal 204

  @api
  Scenario: Test update user normal
    Given prepare url for "CREATE_NEW_USER"
    And hit api post create new user
    Then validation status code is equal 201
    Then validation response body post create new user
    And hit api update user
    Then validation status code is equal 200
    Then Validation response body update user

#  @api
#  Scenario: Test create Wrong New User Wrong
#    Given prepare url valid for "CREATE_NEW_USER"
#    And hit api post create wrong new user
#    Then validation status code is equal 201
#    Then validation response body post create new user
#    Then validation response json with JSONschema "post_create_user_normal.json"


