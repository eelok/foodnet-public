function loginStudent() {
    cy.get('input[name=username]').type("student");
    cy.get('input[name=password]').type('test');
    cy.get('.btn').contains("Login").click();
}
function loginChef() {
    cy.get('input[name=username]').type("chef");
    cy.get('input[name=password]').type('test');
    cy.get('.btn').contains("Login").click();
}

describe('Recipes Page Test', function () {
    beforeEach(function () {
        cy.visit('localhost:8080/recipes');
    });
    it('Get Title', function () {
        loginStudent();
        cy.title().should('eq', 'Recipes');
    });
    it("Student does not see Button", function () {
        loginStudent();
        cy.get('[data-cy=newRecipe]').should('not.be.visible')
    });
    it("Chef sees Button", function () {
        loginChef();
        cy.get('[data-cy=newRecipe]').should('be.visible')
    })
});