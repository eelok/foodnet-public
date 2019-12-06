function login() {
    cy.get('input[name=username]').type("chef");
    cy.get('input[name=password]').type('test');
    cy.get('.btn').contains("Login").click();
}

describe('new Recipe Page Test', function () {
    beforeEach(function () {
        cy.visit('http://localhost:8080/recipes/new');
        login();
    });
    it('Test Create Recipe', function () {
        cy.get('input[id=recipe_name]').type("pasta pesto rosso");
        cy.get('input[id=prepare_time]').clear().type("13");
        cy.get('input[id=cook_time]').clear().type("20");
        cy.get('input[id=ingredients]').type("mushrooms:40, avocado:20, carrot:30");
        cy.get('textarea[id=description]').type(
            "There's nothing like the taste of a cake you made in your own kitchen.");
        cy.get('.btn').contains('Create Recipe').click();
    });
});