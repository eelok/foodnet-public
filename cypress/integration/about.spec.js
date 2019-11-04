describe('About us Test', function() {
    it('Get Title', function() {
        cy.visit('localhost:8080/about');
        cy.title().should("eq","About Us");
    });
    it("Has project members", function() {
        cy.visit('localhost:8080/about');
        cy.contains("project members")
    });
    it("Has time", function() {
        cy.visit('localhost:8080/about');
        cy.contains("time is")
    });
});